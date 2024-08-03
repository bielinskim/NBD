const result = db.people.aggregate([
  {
    $group: {
      _id: "$job",
      count: { $sum: 1 },
    },
  },
  {
    $match: {
      count: 1,
    },
  },
  {
    $project: {
      _id: 0,
      job: "$_id",
    },
  },
]);

printjson(result);
