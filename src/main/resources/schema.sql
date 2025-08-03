CREATE TABLE IF NOT EXISTS public.employee
(
    id bigint NOT NULL,
    first_name varchar(100),
    last_name varchar(100),
    employee_id bigint,
    CONSTRAINT employee_pkey PRIMARY KEY (id)
)
