CREATE TABLE book (
    id integer NOT NULL,
    title character varying(255),
    author character varying(255),
    description character varying(255),
    creation_date timestamp without time zone,
    last_modified_date timestamp without time zone,
    last_modified_by character varying(255)
);
CREATE SEQUENCE book_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE book_id_seq OWNED BY book.id;
ALTER TABLE ONLY book ALTER COLUMN id SET DEFAULT nextval('book_id_seq'::regclass);
ALTER TABLE ONLY book ADD CONSTRAINT book_pkey PRIMARY KEY (id);

CREATE TABLE employee (
    id integer NOT NULL,
    name character varying(255),
    role character varying(255),
    password character varying(255),
    email character varying(255),
    creation_date timestamp without time zone,
    last_modified_date timestamp without time zone,
    last_modified_by character varying(255)
);

CREATE SEQUENCE employee_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE employee_id_seq OWNED BY employee.id;
ALTER TABLE ONLY employee ALTER COLUMN id SET DEFAULT nextval('employee_id_seq'::regclass);
ALTER TABLE ONLY employee ADD CONSTRAINT employee_pkey PRIMARY KEY (id);