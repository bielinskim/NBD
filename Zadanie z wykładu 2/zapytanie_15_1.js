const mapFn = function () {
    if(this.sex === 'Female' && this.nationality === 'Poland') {
        this.credit.forEach((credit) => {
            emit(credit.currency, Number(credit.balance));
          });
    }
  };
  
  const reduceFn = function (key, balance) {
    return {
      avg: Array.avg(balance),
      sum: Array.sum(balance),
    };
  };
  
  const result = db.people.mapReduce(mapFn, reduceFn, { out: { inline: 1 } });
  
  printjson(result);
  