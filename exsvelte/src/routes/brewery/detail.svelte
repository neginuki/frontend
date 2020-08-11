<script>
  import { onMount } from "svelte";

  export let params = {};

  let brewery = {};

  onMount(async () => {
    const response = await fetch(
      `http://localhost:8080/breweries/${params.id}`
    );
    brewery = await response.json();
  });
</script>

<style>
  div {
    margin-bottom: 20px;
  }
  div span:first-child {
    margin: 10px;
    padding-right: 10px;
    border-bottom: 5px solid blue;
  }
</style>

<main>
  <h1>蔵元詳細</h1>
  <div>
    <span>ID</span>
    <span>{params.id}</span>
  </div>
  <div>
    <span>蔵名</span>
    <span>{brewery.breweryName}({brewery.breweryNameKana})</span>
  </div>
  <div>
    <span>住所</span>
    <span>{brewery.address}</span>
  </div>
  <div>
    <span>創業・設立</span>
    {#if brewery.foundedYear}
      <span>{brewery.foundedYear}年</span>
    {:else}
      <span>創業不明</span>
    {/if}
    {#if brewery.establishedDate}
      <span>・{brewery.establishedDate}設立</span>
    {/if}
    {#if brewery.defunctDate}
      <span>・{brewery.defunctDate}廃業</span>
    {/if}
  </div>
  <div>
    <span>URL</span>
    {#if brewery.url}
      <span>{brewery.url}</span>
    {:else}
      <span>なし</span>
    {/if}
  </div>
  <div>
    <span>備考</span>
    {#if brewery.note}
      <span>{brewery.note}</span>
    {:else}
      <span>なし</span>
    {/if}
  </div>
</main>
