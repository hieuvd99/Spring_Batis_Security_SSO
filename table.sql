	CREATE TABLE tb_user
	(
	  user_id serial NOT NULL,
	  user_name text NOT NULL UNIQUE,
	  password text NOT NULL,
	  email text UNIQUE,
	  PRIMARY KEY (user_id)
	) WITHOUT OIDS;
