create table article
(
    id       varchar(100) not null
        primary key,
    authorId varchar(100) null,
    infoData text         null,
    time     datetime     null
)
    comment '朋友圈数据';

create table logininfo
(
    id       varchar(100) not null
        primary key,
    username varchar(16)  null,
    password varchar(16)  null
)
    comment '用户账号密码';

create table mygroup
(
    id            varchar(100) not null
        primary key,
    introduce     varchar(100) null,
    groupMasterId varchar(100) null,
    groupname     varchar(16)  null
)
    comment '群组信息';

create table user
(
    id          varchar(100)                 not null
        primary key,
    username    varchar(16)                  null,
    description varchar(3000)                null,
    introduce   varchar(100)                 null,
    gender      char default (_utf8mb4'ç·') null,
    age         int                          null
)
    comment '用户信息';

create table commentart
(
    articleId varchar(100) null,
    userGood  varchar(100) null,
    info      text         null,
    id        varchar(100) not null
        primary key,
    constraint articleforkeyCom
        foreign key (articleId) references article (id),
    constraint groupUserForkeyC
        foreign key (userGood) references user (id)
)
    comment '朋友圈评论表';

create table goodart
(
    articleId varchar(100) null,
    userGood  varchar(100) null,
    constraint articleforkey
        foreign key (articleId) references article (id),
    constraint groupUserForkeyA
        foreign key (userGood) references user (id)
)
    comment '朋友圈点赞表';

create table groupcontainer
(
    groupId  varchar(100)  null,
    userId   varchar(100)  null,
    groupRel int default 0 null,
    constraint groupcontainer_ibfk_1
        foreign key (groupId) references mygroup (id),
    constraint groupcontainer_ibfk_2
        foreign key (userId) references user (id)
)
    comment '群组成员表';

create index groupId
    on groupcontainer (groupId);

create index groupUserForkey
    on groupcontainer (userId);

create table relation
(
    presId       varchar(100) null,
    afterId      varchar(100) null,
    relationShip int          null,
    constraint relation_ibfk_1
        foreign key (presId) references user (id),
    constraint relation_ibfk_2
        foreign key (afterId) references user (id),
    check ((`relationShip` = 1) or (`relationShip` = 0))
)
    comment '用户关系';

create index afterId
    on relation (afterId);

create index presId
    on relation (presId);

