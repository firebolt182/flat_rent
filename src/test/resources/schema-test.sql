create table if not exists flat (id serial primary key,
                                 region varchar(100) NOT NULL,
                                 city varchar(100) NOT NULL,
                                 street varchar(100) NOT NULL,
                                 home_number varchar(100) NOT NULL,
                                 room_count integer NOT NULL);
