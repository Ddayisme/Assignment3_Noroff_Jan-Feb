INSERT INTO franchise ("description", "name") VALUES ('Tenet Stuff', 'Tenet Franchise');
INSERT INTO franchise ("description", "name") VALUES ('Floklipa crazyness', 'Floklipa Franchise');
INSERT INTO franchise ("description", "name") VALUES ('Wizard School', 'Harry Potter Franchise');

INSERT INTO movies ("director", "genre", "picture", "release_year", "title", "trailer", "franchise_id") VALUES ('Christopher Nolan', 'Sci-fi', 'tenet_image_url', 2020, 'Tenet', 'youtube.com/tenet', 1);
INSERT INTO movies ("director", "genre", "picture", "release_year", "title", "trailer", "franchise_id") VALUES ('Ivo Kaprino', 'Komedie', 'Floklipa_image_url', 1975, 'Floklipa Granprix', 'youtube.com/floklipa', 2);
INSERT INTO movies ("director", "genre", "picture", "release_year", "title", "trailer", "franchise_id") VALUES ('Chris Columbus', 'Fantasy', 'harrypotter_image_url', 2001, 'Harry Potter Nr 1','youtube.com/harry1', 3);
INSERT INTO movies ("director", "genre", "picture", "release_year", "title", "trailer", "franchise_id") VALUES ('Chris Columbus', 'Fantasy', 'harrypotter2_image_url', 2003, 'Harry Potter Nr 2','youtube.com/harry2', 3);

INSERT INTO character ("alias", "full_name", "gender", "picture") VALUES ('Harry Potter', 'Daniel Radcliffe', 'male', 'daniel_picture');
INSERT INTO character ("alias", "full_name", "gender", "picture") VALUES ('Solan Gundersen', 'en fugl', 'male', 'solan_gundy_imagne');

INSERT INTO movies_characters ("movies_id", "character_id") VALUES (3,1);
INSERT INTO movies_characters ("movies_id", "character_id") VALUES (2,2);
INSERT INTO movies_characters ("movies_id", "character_id") VALUES (4,1);
