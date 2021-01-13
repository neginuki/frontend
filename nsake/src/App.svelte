<script lang="ts">
    import Router from "svelte-spa-router";
    import Menu from "./contents/Menu.svelte";
    import Home from "./contents/Home.svelte";
    import CarbonSample from "./contents/carbon/Sample.svelte";
    import SvelteSample from "./contents/svelte/Sample.svelte";
    import SmelteSample from "./contents/smelte/Sample.svelte";
    import MaterialSample from "./contents/material/Sample.svelte";
    import MaterializeSample from "./contents/materialize/Sample.svelte";
    import SveltrapSample from "./contents/sveltrap/Sample.svelte";

    const routes = {
        "/": Home,
        "/carbon": CarbonSample,
        "/svelte": SvelteSample,
        "/smelte": SmelteSample,
        "/material": MaterialSample,
        "/materialize": MaterializeSample,
        "/sveltrap": SveltrapSample,
    };
</script>

<style>
</style>

<main>
    <Menu />
    <Router {routes} />
</main>
