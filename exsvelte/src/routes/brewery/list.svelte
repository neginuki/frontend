<script>
  import { onMount } from "svelte";
  import { push } from "svelte-spa-router";

  let data = [];

  onMount(async () => {
    const response = await fetch("http://localhost:8080/breweries/");
    data = await response.json();
  });
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
        <th>ID</th>
        <th>蔵名</th>
        <th>かな</th>
        <th>住所</th>
      </tr>
    </thead>
    <tbody>
      {#each data as item}
        <tr on:click={() => push(`/brewery/detail/${item.breweryId}`)}>
          <td>{item.breweryId}</td>
          <td>{item.breweryName}</td>
          <td>{item.breweryNameKana}</td>
          <td>{item.address}</td>
        </tr>
      {/each}
    </tbody>
  </table>
</main>
