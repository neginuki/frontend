<script lang="ts">
    import M from "materialize-css";
    import "materialize-css/dist/css/materialize.css";
    import { onMount } from "svelte";
    onMount(() => {
        M.AutoInit();
    });

    let breweryName = null;
    let breweryNameKana = null;
    let address = null;
    let foundedYear = null;
    let establishedDate = null;
    let defunctDate = null;
    let liquors = [];
    let status = "DRAFT";
    let status2 = "STOP";
    let url = null;
    let note = null;
    // エラー文言
    let breweryNameMessage = "";

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
                status2: status2,
                url: url,
                note: note,
            }),
        });

        return await response.json();
    };

    const validateAvailableBreweryName = async () => {
        const response = await fetch(
            "http://localhost:8080/breweries/" + breweryName,
            {
                method: "GET",
                headers: {
                    Accept: "application/json",
                    "Content-Type": "application/json",
                },
            }
        );

        breweryNameMessage =
            response.status === 404 ? "OK" : "既に存在するため利用できません";
    };
</script>

<style>
    div div {
        margin: 20px;
    }
</style>

<main>
    <h1>蔵元作成</h1>

    <form>
        <div>
            <div>
                <span>蔵名</span>
                <input
                    bind:value={breweryName}
                    on:keyup={validateAvailableBreweryName}
                    placeholder="e.g. 廣木酒造本店" />
                <span class="helper-text">{breweryNameMessage}</span>
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
                    class="datepicker"
                    placeholder="e.g. 1919-12-31" />
            </div>
            <div>
                <span>廃業</span>
                <input bind:value={defunctDate} placeholder="e.g. 2000-02-01" />
            </div>
            <div>
                <span>取り扱い</span>
                <label>
                    <input
                        type="checkbox"
                        bind:group={liquors}
                        value="nihonshu" /><span>日本酒</span>
                </label>
                <label>
                    <input
                        type="checkbox"
                        bind:group={liquors}
                        value="shochu" /><span>焼酎</span>
                </label>
                <label>
                    <input
                        type="checkbox"
                        bind:group={liquors}
                        value="wine" /><span>ワイン</span>
                </label>
            </div>
            <div>
                <span>ステータス</span>
                <label>
                    <input
                        type="radio"
                        bind:group={status}
                        value="DRAFT" /><span>未公開</span>
                </label>
                <label>
                    <input
                        type="radio"
                        bind:group={status}
                        value="RUNNING" /><span>公開中</span>
                </label>
                <label>
                    <input
                        type="radio"
                        bind:group={status}
                        value="STOP" /><span>停止中</span>
                </label>
            </div>
            <div class="input-field">
                <select id="status2" bind:value={status2}>
                    <option value="DRAFT">未公開</option>
                    <option value="RUNNING">公開中</option>
                    <option value="STOP">停止中</option>
                </select>
                <label for="status2">ステータス2</label>
            </div>
            <div>
                <span>URL</span>
                <input bind:value={url} placeholder="e.g. http://xxxx.yyyy" />
            </div>
            <div>
                <span>備考</span>
                <textarea
                    bind:value={note}
                    class="materialize-textarea"
                    placeholder="e.g. オフレコですが、実は、、、" />
            </div>
        </div>

        <button on:click|once={createBrewery}>登録</button>
    </form>
</main>
