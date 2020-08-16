<script>
  import { push } from "svelte-spa-router";

  let breweryName = null;
  let breweryNameKana = null;
  let address = null;
  let foundedYear = null;
  let establishedDate = null;
  let defunctDate = null;
  let url = null;
  let note = null;

  let data = [];

  const createBrewery = async () => {
    const response = await fetch("http://localhost:8080/breweries/", {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json"
      },
      body: JSON.stringify({
        breweryName: breweryName,
        breweryNameKana: breweryNameKana,
        address: address,
        foundedYear: foundedYear,
        establishedDate: establishedDate,
        defunctDate: defunctDate,
        url: url,
        note: note
      })
    });

    data = await response.json();

    push(`/brewery/detail/${data.breweryId}`);
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

<main>
  <h1>蔵元作成</h1>
  <div>
    <div>
      <span>蔵名</span>
      <input bind:value={breweryName} placeholder="e.g. 廣木酒造本店" />
    </div>
    <div>
      <span>蔵名（かな）</span>
      <input
        bind:value={breweryNameKana}
        placeholder="e.g. ひろきしゅぞうほんてん" />
    </div>
    <div>
      <span>住所</span>
      <input bind:value={address} placeholder="e.g. 福島県会津若松市XXX " />
    </div>
    <div>
      <span>創業</span>
      <input type="number" bind:value={foundedYear} placeholder="e.g. 1978" />
    </div>
    <div>
      <span>設立</span>
      <input bind:value={establishedDate} placeholder="e.g. 1919-12-31" />
    </div>
    <div>
      <span>廃業</span>
      <input bind:value={defunctDate} placeholder="e.g. 2000-01-01" />
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
</main>
