import React from "react";
import PropTypes from "prop-types";
import { T } from "amiga-core/components/i18n";
import { connect } from "amiga-core/application";
import { BasicGrid } from "amiga-core/components/grid";
import lifecycle from "amiga-core/components/lifecycle";
import { gridConfig } from "@/products/components/tables/products-table/config";
import {
  fetchProducts,
} from "@/products/actions";
import {
  getData,
  getLoading,
} from "@/products/reducers";

const ProductsPage = ({ data, loading }) => {
  const dataSource = {
    getInitialData: () => ({
      data,
    }),
  };

  return (
    <div>
      <h3><T id="products.page.title" /></h3>
      <BasicGrid config={gridConfig()} dataSource={dataSource} loading={loading} />
    </div>
  );
};

ProductsPage.propTypes = {
  data: PropTypes.array,
  loading: PropTypes.bool,
};

const storeConnected = connect(
  state => ({
    data: getData(state),
    loading: getLoading(state),
  }),
);

const injectLifecycle = lifecycle({
  componentDidMount() {
    const { dispatch } = this.props;
    dispatch(fetchProducts());
  },
});

export default storeConnected(injectLifecycle(ProductsPage));
