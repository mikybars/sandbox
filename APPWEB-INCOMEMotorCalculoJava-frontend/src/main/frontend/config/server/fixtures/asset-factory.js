
export default function productsPageFactory() {
  return {
    asset: Array(1000).fill().map((_, i) => ({
      id: i,
      name: `asset ${i}`,
      createdAt: new Date(),
    })),
  };
}
