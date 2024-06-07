package enum0;

public class EnumError {
    // HTTP 상태 코드와 해당 코드에 대한 한글 에러 메시지를 나타내는 열거형
    enum HttpStatus {
        OK(200, "성공"),
        BAD_REQUEST(400, "잘못된 요청"),
        UNAUTHORIZED(401, "인증 실패"),
        NOT_FOUND(404, "찾을 수 없음"),
        INTERNAL_SERVER_ERROR(500, "내부 서버 오류");

        private final int code;
        private final String message;

        HttpStatus(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }

    public static void main(String[] args) {
        // HttpStatus 열거형 사용
        HttpStatus error = HttpStatus.NOT_FOUND;
        System.out.println("에러 코드: " + error.getCode());
        System.out.println("에러 메시지: " + error.getMessage());
    }
}
