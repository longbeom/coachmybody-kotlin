package co.longbeom.kotdemo.user.domain.repository

import co.longbeom.kotdemo.user.domain.UserAuth
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserAuthRepository : JpaRepository<UserAuth, Long> {

}