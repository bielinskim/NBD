printjson(
  db.people.aggregate([
    {
      $group: {
        _id: "$sex",
        height: { $avg: { $toDouble: "$height" } },
        weight: { $avg: { $toDouble: "$weight" } },
      },
    },
  ])
);
