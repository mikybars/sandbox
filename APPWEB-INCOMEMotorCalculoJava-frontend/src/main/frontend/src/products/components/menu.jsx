
import React from "react";
import { T } from "amiga-core/components/i18n";
import { MenuItems, MenuItem, MenuLink } from "amiga-core/components/menus";

const menu = (
  <MenuItems>
    <MenuItem>
      <MenuLink to="/list-products">
        <T id="products.menu.label" />
      </MenuLink>
    </MenuItem>
  </MenuItems>
);

export default menu;
