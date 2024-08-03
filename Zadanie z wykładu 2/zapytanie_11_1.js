const mapFn = function () {
  emit(this.sex, {
    height: Number(this.height),
    weight: Number(this.weight),
  });
};

const reduceFn = function (sex, values) {
  const heights = values.map(({ height }) => height);
  const weights = values.map(({ weight }) => weight);

  return {
    height: Array.avg(heights),
    weight: Array.avg(weights),
  };
};

const result = db.people.mapReduce(mapFn, reduceFn, { out: { inline: 1 } });

printjson(result);
