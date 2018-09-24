import React from "react";
import ProductsPage from "@/products/components/products-page";

export default [
  { path: "/", exact: true, redirect: "/list-products" },
  { path: "/list-products", exact: true, component: ProductsPage },
];
