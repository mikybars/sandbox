import React from "react";
import { T, intl } from "amiga-core/components/i18n";
import CustomTableLoadingOverlay from "@/application/components/custom-table-loading-overlay";

const columnsConfig = [
  {
    label: <T id="products.table.header.id" />,
    style: {
      textAlign: "center",
      paddingLeft: 20,
    },
    minWidth: 300,
    value: ({ id }) => id,
  },
  {
    label: <T id="products.table.header.name" />,
    style: {
      textAlign: "center",
      paddingLeft: 20,
    },
    minWidth: 300,
    value: ({ name }) => name,
  },
];

const menu = {
  features: {
    visibility: false,
    lock: false,
    reorder: false,
  },
};

export const gridConfig = () => ({
  rowHeight: () => 42,
  columns: columnsConfig,
  rowIdentifier: row => row.id,
  emptyDataMessage: () => intl.formatMessage({ id: "products.table.noRegisters" }),
  overlay: (<CustomTableLoadingOverlay text={(<T id="products.table.loadingRegisters" />)} />),
  menu,
});
