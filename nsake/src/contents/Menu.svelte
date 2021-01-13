<script lang="ts">
    import { Navbar, NavbarBrand, Nav, NavItem, NavLink } from "sveltestrap";
</script>

<style>
</style>

<Navbar color="primary">
    <Nav>
        <NavItem>
            <NavLink class="text-white" href="#/" active>HOME</NavLink>
        </NavItem>
        <NavItem>
            <NavLink class="text-white" href="#/carbon">Carbon</NavLink>
        </NavItem>
        <NavItem>
            <NavLink class="text-white" href="#/svelte">Svelte(デフォ)</NavLink>
        </NavItem>
        <NavItem>
            <NavLink class="text-white" href="#/smelte">Smelte</NavLink>
        </NavItem>
        <NavItem>
            <NavLink class="text-white" href="#/material">Material</NavLink>
        </NavItem>
        <NavItem>
            <NavLink class="text-white" href="#/materialize">
                Materialize
            </NavLink>
        </NavItem>
        <NavItem>
            <NavLink class="text-white" href="#/sveltrap">Sveltrap</NavLink>
        </NavItem>
    </Nav>
</Navbar>
