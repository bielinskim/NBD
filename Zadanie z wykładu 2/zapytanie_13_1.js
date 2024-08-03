const mapFn = function () {
  emit("uniqueJobs", this.job);
};

const reduceFn = function (key, jobs) {
  const jobsCount = {};

  jobs.forEach((job) => {
    if (jobsCount[job] === undefined) {
      jobsCount[job] = 1;
    } else {
      jobsCount[job] += 1;
    }
  });

  const uniqueJobs = [];

  Object.entries(jobsCount).forEach(([key, value]) => {
    if (value === 1) {
      uniqueJobs.push(key);
    }
  });

  return uniqueJobs;
};

const result = db.people.mapReduce(mapFn, reduceFn, { out: { inline: 1 } });

printjson(result);
