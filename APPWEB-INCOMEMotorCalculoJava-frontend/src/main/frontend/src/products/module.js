import { module } from "amiga-core/application";
import messages from "root/config/messages/products";
import routes from "./routes";
import reducers from "./reducers";
import menu from "@/products/components/menu";

export default module({
  key: "products",
  menu,
  messages,
  routes,
  reducer: reducers,
});
