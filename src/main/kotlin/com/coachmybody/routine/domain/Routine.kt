package com.coachmybody.routine.domain

import com.coachmybody.user.domain.User
import javax.persistence.*

@Entity
data class Routine(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?,
        @Column(name = "title", nullable = false)
        var title: String,
        @JoinColumn(name = "user_id", nullable = false)
        @ManyToOne(fetch = FetchType.LAZY)
        val user: User
) {
    constructor(title: String, user: User) : this(null, title, user)
}