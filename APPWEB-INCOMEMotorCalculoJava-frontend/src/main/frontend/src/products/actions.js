import { PROMISE_CALL } from "amiga-core/application/actions";
import api from "@/products/api";

export const PRODUCTS_FETCH = "PRODUCTS_FETCH";

export const fetchProducts = () => ({
  type: PRODUCTS_FETCH,
  [PROMISE_CALL]: () => api.fetchProducts().then(res => res.json()),
});
