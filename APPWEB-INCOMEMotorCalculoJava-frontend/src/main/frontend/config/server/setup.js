export default server => {
  server.get("/credentials", (req, res) => {
    res.json({
      "login": "jesusmpc@inditex.com",
      "roles": ["admin", "user"],
    });
  });

  server.get("/product", (req, res) => {
    res.json([
      {
        "id": 1,
        "name": "PRODUCT 1"
      },
      {
        "id": 2,
        "name": "PRODUCT 2"
      },
      {
        "id": 3,
        "name": "PRODUCT 3"
      },
      {
        "id": 4,
        "name": "PRODUCT 4"
      },
      {
        "id": 5,
        "name": "PRODUCT 5"
      }
    ]);
  });
};
