create table contact (
  id                            bigserial not null,
  name                          varchar(255),
  photo_url                     varchar(255),
  date_created                  date,
  constraint pk_contact primary key (id)
);

