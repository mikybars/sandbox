import { configBuilder } from "amiga-tools/dev";

const baseConfig = configBuilder().buildDefaultProdConfig();

export default {
  ...baseConfig,
  output: {
    ...baseConfig.output,
    path: process.env.DIST_PATH,
  },
};
