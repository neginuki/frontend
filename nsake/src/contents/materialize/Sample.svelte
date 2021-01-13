<script lang="ts">
    let breweryName = null;
    let breweryNameKana = null;
    let address = null;
    let foundedYear = null;
    let establishedDate = null;
    let defunctDate = null;
    let liquors = [];
    let status = "DRAFT";
    let url = null;
    let note = null;

    const createBrewery = async (event: any) => {
        event.currentTarget.innerHTML = "登録処理中です・・・";
        event.currentTarget.disabled = true;

        const response = await fetch("http://localhost:8080/breweries/", {
            method: "POST",
            headers: {
                Accept: "application/json",
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                brewery_name: breweryName,
                brewery_name_kana: breweryNameKana,
                address: address,
                founded_year: foundedYear,
                established_date: establishedDate,
                defunct_date: defunctDate,
                liquors: liquors,
                status: status,
                url: url,
                note: note,
            }),
        });

        return await response.json();
    };
</script>

<style>
    div div {
        margin: 20px;
    }
    textarea {
        width: 500px;
        height: 250px;
    }
</style>

<svelte:head>
    <link
        rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css" />
    <script
        src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js">
    </script>
</svelte:head>

<main>
    <h1>蔵元作成</h1>

    <form>
        <div>
            <div>
                <span>蔵名</span>
                <input
                    bind:value={breweryName}
                    placeholder="e.g. 廣木酒造本店" />
            </div>
            <div>
                <span>蔵名（かな）</span>
                <input
                    bind:value={breweryNameKana}
                    placeholder="e.g. ひろきしゅぞうほんてん" />
            </div>
            <div>
                <span>住所</span>
                <input
                    bind:value={address}
                    placeholder="e.g. 福島県会津若松市XXX " />
            </div>
            <div>
                <span>創業</span>
                <input
                    type="number"
                    bind:value={foundedYear}
                    placeholder="e.g. 1978" />年
            </div>
            <div>
                <span>設立</span>
                <input
                    bind:value={establishedDate}
                    placeholder="e.g. 1919-12-31" />
            </div>
            <div>
                <span>廃業</span>
                <input bind:value={defunctDate} placeholder="e.g. 2000-01-01" />
            </div>
            <div>
                <span>取り扱い</span>
                <input
                    type="checkbox"
                    bind:group={liquors}
                    value="nihonshu" />日本酒
                <input
                    type="checkbox"
                    bind:group={liquors}
                    value="shochu" />焼酎
                <input
                    type="checkbox"
                    bind:group={liquors}
                    value="wine" />ワイン
            </div>
            <div>
                <span>ステータス</span>
                <input
                    type="radio"
                    name="status"
                    bind:group={status}
                    value="DRAFT" />未公開
                <input
                    type="radio"
                    name="status"
                    bind:group={status}
                    value="RUNNING" />公開中
                <input
                    type="radio"
                    name="status"
                    bind:group={status}
                    value="STOP" />停止中
            </div>
            <div>
                <span>URL</span>
                <input bind:value={url} placeholder="e.g. http://xxxx.yyyy" />
            </div>
            <div>
                <span>備考</span>
                <textarea
                    bind:value={note}
                    placeholder="e.g. オフレコですが、実は、、、" />
            </div>
        </div>

        <button on:click|once={createBrewery}>登録</button>
    </form>
</main>
