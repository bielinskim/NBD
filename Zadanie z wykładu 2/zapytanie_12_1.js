const mapFn = function () {
  this.credit.forEach((credit) => {
    emit(credit.currency, Number(credit.balance));
  });
};

const reduceFn = function (currency, balance) {
  return {
    balance: Array.sum(balance),
  };
};

const result = db.people.mapReduce(mapFn, reduceFn, { out: { inline: 1 } });

printjson(result);
