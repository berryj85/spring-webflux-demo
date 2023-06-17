package berryj85.demo.dataservice.module.user

import berryj85.demo.dataservice.module.response.UserProfile
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller
import reactor.core.publisher.Mono
import java.math.BigDecimal

@Controller
class UserProfileController(val userProfileService: UserProfileService) {

    @SchemaMapping(typeName = "Query", field = "userProfile")
    fun getUserProfile(@Argument("username") username:String):Mono<UserProfile>{
        return userProfileService.getUserProfileByUsername(username)
    }

    @SchemaMapping(typeName = "UserProfile", field = "couponBalance")
    fun getTotalCoupon(@Argument("username") username:String):Mono<Long>{
        return userProfileService.getTotalCoupon(username).count()
    }

    @SchemaMapping(typeName = "UserProfile", field = "coinBalance")
    fun getCoinBalance(userProfile:UserProfile):Mono<BigDecimal>{
        return userProfileService.getCoinBalanceByUsername(userProfile.username)
    }

}