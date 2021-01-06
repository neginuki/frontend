<script lang="ts">
    import Router from "svelte-spa-router";
    import Blank from "./contents/Blank.svelte";
    import Body1 from "./contents/Body1.svelte";

    import { link } from "svelte-spa-router";

    const routes = {
        "/": Blank,
        "/body1": Body1,
    };
</script>

<style>
</style>

<main>
    <div class="menu"><a href="#/">#</a></div>
    <div class="menu"><a href="#/body1">Body1</a></div>

    <Router {routes} />
</main>
