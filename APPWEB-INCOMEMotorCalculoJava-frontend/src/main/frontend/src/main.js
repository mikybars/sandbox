import "amiga-styles/faro/bundle.css";
import products from "@/products/module";
import { get } from "amiga-core/application/api-utils";
import { renderApplication } from "amiga-core/application";

const authentication = {
  getCredentials: () =>
    get(`/credentials`, {
      mode: "cors",
      credentials: "include",
    }).then(res => res.json()),
  forceLogout: false,
  requestLogout: () =>
    Promise.resolve(null),
};

renderApplication({
  rootNodeId: "app",
  authentication,
  modules: [
    products,
  ],
});
