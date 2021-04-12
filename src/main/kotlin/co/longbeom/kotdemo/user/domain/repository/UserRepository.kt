package co.longbeom.kotdemo.user.domain.repository

import co.longbeom.kotdemo.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long> {

}