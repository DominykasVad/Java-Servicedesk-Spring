create table configuration_item_status
(
    id bigint auto_increment
        primary key,
    created_at datetime(6) null,
    name varchar(255) not null,
    updated_at datetime(6) null,
    constraint UK_3122rrtpuek622qch3w6955pl
        unique (name)
);

create table organizational_units
(
    id bigint auto_increment
        primary key,
    created_at datetime(6) null,
    ou_name varchar(255) not null,
    updated_at datetime(6) null,
    constraint UK_6gxiy6r4ihquhja4ijkd7o311
        unique (ou_name)
);

create table locations
(
    id bigint auto_increment
        primary key,
    created_at datetime(6) null,
    name varchar(255) not null,
    updated_at datetime(6) null,
    ou_id bigint null,
    constraint FKgfrf5gqmwtfhg1m56o4mmfcyr
        foreign key (ou_id) references organizational_units (id)
);

create table configuration_items
(
    id bigint auto_increment
        primary key,
    created_at datetime(6) null,
    description varchar(255) null,
    inventory_number varchar(255) null,
    model varchar(255) null,
    name varchar(255) not null,
    serial_number varchar(255) not null,
    updated_at datetime(6) null,
    vendor varchar(255) null,
    status bigint null,
    location_id bigint null,
    ou_id bigint null,
    constraint UK_7vta1p2un7d7m0t342k5wihs4
        unique (inventory_number),
    constraint UK_tp670bq9yxn5gilvah6g1itpj
        unique (serial_number),
    constraint FK2g1yqjtjspsecnja87c4ufg05
        foreign key (location_id) references locations (id),
    constraint FKf0o8uywp7xiadkawkb8cmed3r
        foreign key (ou_id) references organizational_units (id),
    constraint FKi05nft0vxmve8ywkjnusmkynn
        foreign key (status) references configuration_item_status (id)
);

create table ci_sr
(
    ci_id bigint not null,
    sr_id bigint not null,
    primary key (ci_id, sr_id),
    constraint FKgp4ljto44unwwsvpa2c7wcxv9
        foreign key (ci_id) references configuration_items (id)
);

create table role
(
    id bigint auto_increment
        primary key,
    role_name varchar(255) null
);

create table service_request_status
(
    id bigint auto_increment
        primary key,
    created_at datetime(6) null,
    name varchar(255) not null,
    updated_at datetime(6) null,
    constraint UK_ofibeytxxl4bqwd8svkchbbag
        unique (name)
);

create table users
(
    id bigint auto_increment
        primary key,
    created_at datetime(6) null,
    email varchar(254) not null,
    name varchar(255) null,
    password varchar(255) not null,
    phone varchar(50) not null,
    surname varchar(255) null,
    updated_at datetime(6) null,
    username varchar(36) not null,
    ou_id bigint null,
    constraint UK_6dotkott2kjsp8vw4d0m25fb7
        unique (email),
    constraint UK_du5v5sr43g5bfnji4vb8hg5s3
        unique (phone),
    constraint UK_r43af9ap4edm43mmtq01oddj6
        unique (username),
    constraint FKson0tnlx8058wt7amofdbjrnt
        foreign key (ou_id) references organizational_units (id)
);

create table user_roles
(
    user_id bigint not null,
    role_id bigint not null,
    primary key (user_id, role_id),
    constraint FKhfh9dx7w3ubf1co1vdev94g3f
        foreign key (user_id) references users (id),
    constraint FKrhfovtciq1l558cw6udg0h0d3
        foreign key (role_id) references role (id)
);

