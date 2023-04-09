CREATE TABLE Client (
  id SERIAL PRIMARY KEY,
  name VARCHAR(200) NOT NULL
);

CREATE TABLE Planet (
  id VARCHAR(20) PRIMARY KEY,
  name VARCHAR(500) NOT NULL
);

CREATE TABLE Ticket (
  id SERIAL PRIMARY KEY,
  created_at TIMESTAMP NOT NULL DEFAULT now(),
  client_id INTEGER NOT NULL REFERENCES Client(id) ON DELETE CASCADE,
  from_planet_id VARCHAR(10) NOT NULL REFERENCES Planet(id) ON DELETE CASCADE,
  to_planet_id VARCHAR(10) NOT NULL REFERENCES Planet(id) ON DELETE CASCADE
);
