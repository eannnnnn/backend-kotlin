package dev.waca.services.user.entities

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

/**
 *     "userId"                 bigint                   default nextval('"user_userId_seq"'::regclass) not null
 *         primary key,
 *     uuid                     varchar(255)
 *         unique,
 *     email                    varchar(255)                                                            not null
 *         unique,
 *     another_user_referral_id bigint
 *                                                                                                      references referral_code
 *                                                                                                          on update cascade on delete set null,
 *     "isActive"               boolean                  default true,
 *     "isSuperUser"            boolean                  default false,
 *     "isStaff"                boolean                  default false,
 *     "countryId"              integer
 *         references country
 *             on update cascade on delete cascade,
 *     password                 varchar(255)                                                            not null,
 *     "createdAt"              timestamp with time zone default now()                                  not null,
 *     duplicate_info           varchar
 *         constraint user_di
 *             unique,
 *     is_agreed_terms          boolean                  default false                                  not null,
 *     is_agreed_promotion      boolean                  default false                                  not null,
 *     "updatedAt"              timestamp with time zone default now()                                  not null,
 *     "isBlocked"              boolean                  default false                                  not null,
 *     "createAt"               timestamp with time zone default now()                                  not null,
 *     login_fail_count         integer                  default 0                                      not null,
 *     otp_fail_count           integer                  default 0                                      not null,
 *     is_affiliate_user        boolean                  default false                                  not null
 */
@Entity
@Table(name = "`user`")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`userId`")
    val userId: Long? = null,

    @Column(name = "uuid")
    val uuid: String = "",

    @Column(name = "email")
    val email: String = "",

    @CreatedDate
    @Column(name = "`createdAt`")
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @LastModifiedDate
    @Column(name = "`updatedAt`")
    val updatedAt: LocalDateTime = LocalDateTime.now()
) {
    constructor() : this(null, "", "", LocalDateTime.now(), LocalDateTime.now()) {

    }
}