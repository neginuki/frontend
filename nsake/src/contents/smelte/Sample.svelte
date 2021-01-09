<script lang="ts">
    //
    import "smelte/src/tailwind.css"; // main.ts でやるっぽい？
    import { Select } from "smelte";

    const items = [
        { value: 1, text: "One" },
        { value: 2, text: "Two" },
        { value: 3, text: "Three" },
        { value: 4, text: "Four" },
    ];

    let label: string = "表示";
    let value1 = "val";
</script>

{value1}
<Select {label} {items} on:change={(v) => (value1 = v.detail)} />
