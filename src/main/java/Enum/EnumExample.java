package Enum;

//열거형
public class EnumExample {
        // Enum for sizes of objects
        enum Size {
            SMALL, MEDIUM, LARGE
        }

        public static void main(String[] args) {
            // Using the Size enum
            Size objectSize = Size.MEDIUM;
            System.out.println("물체의 크기는: " + toKorean(objectSize));

            // Switch statement with enum
            switch (objectSize) {
                case SMALL:
                    System.out.println("물체는 작습니다.");
                    break;
                case MEDIUM:
                    System.out.println("물체는 중간 크기입니다.");
                    break;
                case LARGE:
                    System.out.println("물체는 큽니다.");
                    break;
                default:
                    System.out.println("알 수 없는 크기입니다.");
            }
        }

        // Enum 값을 한글로 변환하는 메서드
        public static String toKorean(Size size) {
            switch (size) {
                case SMALL:
                    return "작음";
                case MEDIUM:
                    return "보통";
                case LARGE:
                    return "큼";
                default:
                    return "알 수 없음";
            }
        }
    }
