package berryj85.demo.dataservice.module.user

import berryj85.demo.dataservice.module.response.UserProfile
import org.apache.logging.log4j.LogManager
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono
import java.math.BigDecimal

@Service
class UserProfileService {
    private companion object {
        val logger = LogManager.getLogger(UserProfileService::class.java)
    }

    fun getUserProfileByUsername(username: String): Mono<UserProfile> {
        return UserProfile(
            username = username,
            creditBalance = BigDecimal.valueOf(100.00)
        ).toMono()
    }

    fun getCoinBalanceByUsername(username: String): Mono<BigDecimal> {
        return BigDecimal.valueOf(40.50).toMono()
    }

    fun getTotalCoupon(username: String): Flux<String> {
        return Flux.fromArray(arrayOf("coupon-1","coupon-2","coupon-3"))
    }
}