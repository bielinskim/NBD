const mapFn = function () {
  const bmi = Number(this.weight) / (Number(this.height) / 100) ** 2;
  emit(this.nationality, bmi);
};

const reduceFn = function (key, bmis) {
  return {
    avg: Array.avg(bmis),
    max: Math.max(...bmis),
    min: Math.min(...bmis),
  };
};

const result = db.people.mapReduce(mapFn, reduceFn, { out: { inline: 1 } });

printjson(result);
