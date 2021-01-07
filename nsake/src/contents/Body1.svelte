<script lang="ts">
    import { Button } from "carbon-components-svelte";
    import { CopyButton } from "carbon-components-svelte";
    import { Dropdown } from "carbon-components-svelte";

    let statuses = [
        { id: 1, text: "元気" },
        { id: 2, text: "超元気" },
        { id: 3, text: "無敵" },
    ];

    let status: string = "無敵";

    let hoge: string = "0";
</script>

<main>
    <Button kind="danger">おれのぼたん</Button>
    <CopyButton on:click />

    <Dropdown
        bind:value={hoge}
        light
        titleText="Contact"
        selectedIndex={0}
        items={[{ id: '0', text: 'Slack' }, { id: '1', text: 'Email' }, { id: '2', text: 'Fax' }]} />

    <div>Dropdown: {hoge}</div>

    <select bind:value={status}>
        {#each statuses as st}
            <option value={st}>{st.text}</option>
        {/each}
    </select>

    <div>Status: {status}</div>
</main>
