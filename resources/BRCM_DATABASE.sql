
CREATE TABLE public.activity (
                name VARCHAR(40) NOT NULL,
                CONSTRAINT name PRIMARY KEY (name)
);


CREATE TABLE public.activity_price (
                date DATE NOT NULL,
                name VARCHAR(40) NOT NULL,
                price DOUBLE PRECISION NOT NULL,
                CONSTRAINT activity_name_date PRIMARY KEY (date, name)
);


CREATE TABLE public.affiliation (
                title VARCHAR(40) NOT NULL,
                discount INTEGER NOT NULL,
                CONSTRAINT title PRIMARY KEY (title)
);
COMMENT ON TABLE public.affiliation IS 'title will be prepopulated with options student, professor or both which will either give the student discount professor discount or both(sum of each discount). A user can select the option for each of these when signing up but it must be validate by the users input for the values needed in the student and professor table. So if a user selects that they are both they need to provide accurate info for each attribute of the professor or student table.';


CREATE TABLE public.status (
                label VARCHAR(40) NOT NULL,
                CONSTRAINT label PRIMARY KEY (label)
);


CREATE SEQUENCE public.address_address_id_seq;

CREATE TABLE public.address (
                address_id INTEGER NOT NULL DEFAULT nextval('public.address_address_id_seq'),
                street VARCHAR NOT NULL,
                number INTEGER NOT NULL,
                zip_code INTEGER NOT NULL,
                city VARCHAR NOT NULL,
                state VARCHAR NOT NULL,
                CONSTRAINT address_id PRIMARY KEY (address_id)
);


ALTER SEQUENCE public.address_address_id_seq OWNED BY public.address.address_id;

CREATE TABLE public.customer (
                bronco_id VARCHAR NOT NULL,
                fn_ln VARCHAR(40) NOT NULL,
                DOB DATE NOT NULL,
                phone VARCHAR(10) NOT NULL,
                address_id INTEGER NOT NULL,
                title VARCHAR(40) NOT NULL,
                CONSTRAINT bronco_id PRIMARY KEY (bronco_id)
);
COMMENT ON TABLE public.customer IS 'In the gui we only need to know the affiliation to determine the discount to calculate total price so we check the title value here for that.';


CREATE TABLE public.professor (
                bronco_id VARCHAR NOT NULL,
                office VARCHAR NOT NULL,
                research VARCHAR NOT NULL,
                department VARCHAR NOT NULL,
                CONSTRAINT professor_bronco_id PRIMARY KEY (bronco_id)
);
COMMENT ON TABLE public.professor IS 'since our application does not have any services from the university there is no way to validate whether a customer who is signing up is actually a student professor, both or neither.';


CREATE TABLE public.student (
                bronco_id VARCHAR NOT NULL,
                minor VARCHAR,
                major VARCHAR NOT NULL,
                grade_date DATE NOT NULL,
                enter_date DATE NOT NULL,
                CONSTRAINT student_bronco_id PRIMARY KEY (bronco_id)
);


CREATE SEQUENCE public.purchase_purchase_id_seq;

CREATE TABLE public.purchase (
                purchase_id INTEGER NOT NULL DEFAULT nextval('public.purchase_purchase_id_seq'),
                time TIME NOT NULL,
                date DATE NOT NULL,
                total_price DOUBLE PRECISION NOT NULL,
                label VARCHAR(40) NOT NULL,
                bronco_id VARCHAR NOT NULL,
                CONSTRAINT purchase_id PRIMARY KEY (purchase_id)
);


ALTER SEQUENCE public.purchase_purchase_id_seq OWNED BY public.purchase.purchase_id;

CREATE TABLE public.activity_purchase (
                purchase_id INTEGER NOT NULL,
                name VARCHAR(40) NOT NULL,
                quantity INTEGER NOT NULL,
                CONSTRAINT name_purchase_id PRIMARY KEY (purchase_id, name)
);
COMMENT ON COLUMN public.activity_purchase.quantity IS 'Number of hours the customers intends to be performing activity';


ALTER TABLE public.activity_purchase ADD CONSTRAINT item_order_item_fk
FOREIGN KEY (name)
REFERENCES public.activity (name)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.activity_price ADD CONSTRAINT item_item_price_fk
FOREIGN KEY (name)
REFERENCES public.activity (name)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.customer ADD CONSTRAINT affiliation_customer_fk
FOREIGN KEY (title)
REFERENCES public.affiliation (title)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.purchase ADD CONSTRAINT status_order_fk
FOREIGN KEY (label)
REFERENCES public.status (label)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.customer ADD CONSTRAINT address_customer_fk
FOREIGN KEY (address_id)
REFERENCES public.address (address_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.purchase ADD CONSTRAINT customer_order_fk
FOREIGN KEY (bronco_id)
REFERENCES public.customer (bronco_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.student ADD CONSTRAINT customer_student_fk
FOREIGN KEY (bronco_id)
REFERENCES public.customer (bronco_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.professor ADD CONSTRAINT customer_professor_fk
FOREIGN KEY (bronco_id)
REFERENCES public.customer (bronco_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.activity_purchase ADD CONSTRAINT order_order_item_fk
FOREIGN KEY (purchase_id)
REFERENCES public.purchase (purchase_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
