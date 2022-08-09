CREATE TABLE item (
	item_id	BIGINT auto_increment	NOT NULL,
	item_group	VARCHAR(30)	NOT NULL,
	item_name	VARCHAR(100)	NOT NULL,
	item_price	INTEGER	NOT NULL,
	item_quantity	INTEGER	NOT NULL,
	primary key (item_id)
);

CREATE TABLE cart (
	item_id	BIGINT 	NOT NULL,
	member_id	BIGINT	NOT NULL,
	cart_quantity	INTEGER	NOT NULL,
	primary key (item_id, member_id),
	FOREIGN KEY (item_id) REFERENCES item (item_id),
	FOREIGN KEY (member_id) REFERENCES member (member_id)
);

CREATE TABLE member (
	member_id	BIGINT auto_increment	NOT NULL,
	member_name	VARCHAR(60)	NOT NULL,
	primary key (member_id)
);


