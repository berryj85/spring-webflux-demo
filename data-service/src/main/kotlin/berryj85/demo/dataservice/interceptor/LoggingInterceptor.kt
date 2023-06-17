package berryj85.demo.dataservice.interceptor

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.graphql.server.WebGraphQlInterceptor
import org.springframework.graphql.server.WebGraphQlRequest
import org.springframework.graphql.server.WebGraphQlResponse
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class LoggingInterceptor : WebGraphQlInterceptor {
    private companion object{
        val logger: Logger = LogManager.getLogger(LoggingInterceptor::class.java)
    }
    override fun intercept(request: WebGraphQlRequest, chain: WebGraphQlInterceptor.Chain): Mono<WebGraphQlResponse> {

        val startTime = System.currentTimeMillis()
        return chain.next(request).doOnSubscribe {
            logger.info("Request document [{}] variables [{}]", request.document.replace("\n"," "),request.variables)
        }.doOnSuccess {response->
            logger.info("Response processing-time [{} ms]", System.currentTimeMillis()-startTime,response.executionResult)
        }
    }
}