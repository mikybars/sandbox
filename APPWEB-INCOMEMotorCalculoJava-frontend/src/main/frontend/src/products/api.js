
import { get } from "amiga-core/application/api-utils";

// Read
const fetchProducts = () => get("/product", { params: {} });

// Exposed api methods
export default {
  fetchProducts,
};
