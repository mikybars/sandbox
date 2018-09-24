import { configBuilder } from "amiga-tools/dev";

const baseConfig = configBuilder().buildDefaultDevConfig();

export default {
  ...baseConfig,
  output: {
    ...baseConfig.output,
    path: process.env.DIST_PATH,
  },
};
