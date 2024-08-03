printjson(
  db.people.insertOne({
    first_name: "Mateusz",
    last_name: "Bielinski",
    sex: "Male",
    job: "Frontend Developer",
    email: "mabielinski@wp.pl",
    location: {
      city: "Warszawa",
      address: { streetname: "Sloneczna", streetnumber: "55" },
    },
    description: "Test",
    height: "170",
    weight: "75",
    birth_date: "1993-04-28T22:56:45Z",
    nationality: "Poland",
    credit: [
      {
        type: "solo",
        number: "5602219899186120000",
        currency: "PLN",
        balance: "1000",
      },
    ],
  })
);
