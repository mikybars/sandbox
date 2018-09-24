import React from "react";
import {
  PRODUCTS_FETCH,
} from "@/products/actions";
import { requestType, successType, failureType } from "amiga-core/application/actions";
import { combineReducers } from "redux";

const initialState = {
  products: {
    data: [],
    loading: false,
  },
};

export function data(state = initialState.products.data, { type, payload }) {
  switch (type) {
    case requestType(PRODUCTS_FETCH):
      return [];
    case successType(PRODUCTS_FETCH):
      return payload.response;
    case failureType(PRODUCTS_FETCH):
      return [];
    default:
      return state;
  }
}

export function loading(state = initialState.products.loading, { type }) {
  switch (type) {
    case requestType(PRODUCTS_FETCH):
      return true;
    case successType(PRODUCTS_FETCH):
      return false;
    case failureType(PRODUCTS_FETCH):
      return false;
    default:
      return state;
  }
}

export const getData = state => state.products.data;
export const getLoading = state => state.products.loading;

export default combineReducers({
  data,
  loading,
});
