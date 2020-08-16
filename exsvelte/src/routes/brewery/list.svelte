<script>
  import { onMount } from "svelte";
  import { push } from "svelte-spa-router";

  let data = [];

  onMount(async () => {
    const response = await fetch("http://localhost:8080/breweries/");
    data = await response.json();
  });

  const deleteBrewery = async (event, breweryId) => {
    event.stopPropagation();

    const response = await fetch(
      `http://localhost:8080/breweries/${breweryId}`,
      { method: "DELETE" }
    );
    await response.json();

    push("/"); // リロードってどうやるんだろう？ ここを /brewery/list にしても再読み込みしてくれない。
  };
</script>

<style>

</style>

<main>
  <h1>
    <span class="badge">蔵元一覧</span>
  </h1>
  <table>
    <thead>
      <tr>
        <th />
        <th>ID</th>
        <th>蔵名</th>
        <th>かな</th>
        <th>住所</th>
      </tr>
    </thead>
    <tbody>
      {#each data as item}
        <tr on:click={() => push(`/brewery/detail/${item.breweryId}`)}>
          <td>
            <button on:click={e => deleteBrewery(e, item.breweryId)}>
              削除
            </button>
          </td>
          <td>{item.breweryId}</td>
          <td>{item.breweryName}</td>
          <td>{item.breweryNameKana}</td>
          <td>{item.address}</td>
        </tr>
      {/each}
    </tbody>
  </table>
</main>
