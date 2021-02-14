package co.longbeom.kotdemo.domain.repository

import co.longbeom.kotdemo.domain.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long> {

}