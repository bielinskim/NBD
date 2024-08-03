const result = db.people
  .aggregate([
    {
      $project: {
        _id: 0,
        nationality: 1,
        weight: { $toDouble: "$weight" },
        height: { $toDouble: "$height" },
        bmi: {
          $divide: [
            { $toDouble: "$weight" },
            { $pow: [{ $divide: [{ $toDouble: "$height" }, 100] }, 2] },
          ],
        },
      },
    },
    {
      $group: {
        _id: "$nationality",
        avg: { $avg: "$bmi" },
        max: { $max: "$bmi" },
        min: { $min: "$bmi" },
      },
    },
  ])
  .toArray();

printjson(result);
